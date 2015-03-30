interface IHashMapable {
    boolean put(HashableObject toPut) throws Exception;

    int size();

    HashableObject get(Long code);
}

public class HashMap implements IHashMapable {
    public final int MAX_SIZE = 1000;

    public HashableObject[] table = new HashableObject[MAX_SIZE];

    public int getCode(HashableObject object) {
        return (object.getKey() % MAX_SIZE);
    }

    @Override
    public boolean put(HashableObject toPut) throws Exception {

        int code = getCode(toPut);
        boolean hasValue = table[code] != null;

        if (!hasValue) {
            table[code] = toPut;
            return true;
        } else {
            //check free space
            boolean hasFreeSpace = this.size() < MAX_SIZE;
            if (!hasFreeSpace) {
                throw new Exception("Table is full.");
            } else {
                int startFindFrom = code;
                boolean isInserted = false;
                boolean hasValueInNextPosition = false;
                while(++startFindFrom <= MAX_SIZE){
                     hasValueInNextPosition = table[startFindFrom] == null;
                    if(!hasValueInNextPosition){
                        //insert here
                        table[startFindFrom] = toPut;
                        isInserted = true;
                        break;
                    }
                }

                if(!isInserted){
                    startFindFrom = 0;
                    while(startFindFrom < code){
                        hasValueInNextPosition = table[++startFindFrom] == null;
                        if(!hasValueInNextPosition){
                            table[startFindFrom] = toPut;
                            isInserted = true;
                            break;
                        }
                    }
                }

                return isInserted;
            }
        }

    }

    @Override
    public int size() {
        int size = 0;
        int i = 0;
        for (; i < MAX_SIZE; i++) {
            if (table[i] != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public HashableObject get(Long code) {
        return null;
    }
}
