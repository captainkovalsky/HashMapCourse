package main;
public class HashMap implements IHashMapable {
    public final int MAX_SIZE = 1000;

    public HashableObject[] table = new HashableObject[MAX_SIZE];

    public int getIndex(int key) {
        return (key % MAX_SIZE);
    }

    @Override
    public boolean put(HashableObject toPut) throws Exception {

        int index = getIndex(toPut.getKey());
        boolean hasValue = table[index] != null;

        if (!hasValue) {
            table[index] = toPut;
            return true;
        } else {
            //check free space
            boolean hasFreeSpace = this.size() < MAX_SIZE;

            if (!hasFreeSpace) {
                throw new Exception("Table is full.");
            } else {
                int probeIndex;
                if (index == MAX_SIZE - 1) {
                    probeIndex = 0;
                } else {
                    probeIndex = index + 1;
                }

                while ((probeIndex != -1) && (probeIndex != index)) {
                    if (table[probeIndex] == null) {
                        table[probeIndex] = toPut;
                        return true;
                    }

                    if (probeIndex == MAX_SIZE - 1) {
                        probeIndex = 0;
                    } else {
                        probeIndex++;
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
        int index = getIndex(key);
        int probeIndex;
        boolean hasValue = table[index] != null;

        if (!hasValue) {
            return null;
        }


        if (table[index].getKey() == key) {
            return table[index];
        }

        probeIndex = index == MAX_SIZE - 1 ? 0 : index + 1;

        while ((probeIndex != -1) && (probeIndex != index)) {

            hasValue = table[probeIndex] != null;

            if (!hasValue) {
                return null;
            }

            if (table[probeIndex].getKey() == key) {
                return table[probeIndex];
            }

            if (probeIndex == MAX_SIZE - 1) {
                probeIndex = 0;
            } else {
                probeIndex++;
            }
        }
        return null;
    }
}
