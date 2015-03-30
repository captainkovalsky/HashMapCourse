package main;

interface IHashMapable {

    boolean put(HashableObject toPut) throws Exception;

    int size();

    HashableObject get(int code);
}