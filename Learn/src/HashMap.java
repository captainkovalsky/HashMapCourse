
interface IHashMapable{
     Boolean put(HashableObject toPut);
     int size();
     HashableObject get(Long code);
}

public class HashMap implements  IHashMapable{
    public final int MAX_SIZE = 1000;

    public HashableObject[] table = new HashableObject[MAX_SIZE];

    public int code(HashableObject object)
    {
        return (object.getKey() % MAX_SIZE);
    }

    @Override
    public Boolean put(HashableObject toPut) {
        int probe;


        int code = code(toPut);

            if (code == (table.length - 1))
                probe = 0;
            else
                probe = code + 1;


        while ( (probe != -1) &&
                (probe != code) )
        {
                if (probe == (table.length -1 ) )
                    probe = 0;
                else
                    probe++;
        }

        return probe == -1;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public HashableObject get(Long code) {
        return null;
    }
}
