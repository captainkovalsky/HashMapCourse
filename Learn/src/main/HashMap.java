package main;
public class HashMap implements IHashMapable {
    public final int MAX_SIZE = 1000;

    public HashableObject[] table = new HashableObject[MAX_SIZE];

    public int getCode(int key) {
        return (key % MAX_SIZE);
    }

    @Override
    public boolean put(HashableObject toPut) throws Exception {

        int code = getCode(toPut.getKey());
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
                int index;
                if (code == MAX_SIZE - 1) {
                    index = 0;
                } else {
                    index = code + 1;
                }

                while ((index != -1) && (index != code)) {
                    if (table[index] == null) {
                        table[index] = toPut;
                        return true;
                    }

                    if (index == MAX_SIZE - 1) {
                        index = 0;
                    } else {
                        index++;
                    }
                }

                return false;
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
    public HashableObject get(int key) {
        int code = getCode(key);
        int index;
        boolean hasValue = table[code] != null;

        if (!hasValue) {
            return null;
        }


        if (table[code].getKey() == key) {
            return table[code];
        }

        index = code == MAX_SIZE - 1 ? 0 : code + 1;

        while ((index != -1) && (index != code)) {

            hasValue = table[index] != null;

            if (!hasValue) {
                return null;
            }

            if (table[index].getKey() == key) {
                return table[index];
            }

            if (index == MAX_SIZE - 1) {
                index = 0;
            } else {
                index++;
            }
        }
        return null;
    }
}
