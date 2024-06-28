class HashTable<K, V> {
    private int capacidad;
    private LinkedList<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        table = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction1(K key) {
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % capacidad;
    }

    public void put(K key, V value) {
        int indice = hashFunction1(key);
        LinkedList<K, V> bucket = table[indice];
        bucket.add(key, value);
    }

    public V get(K key) {
        int indice = hashFunction1(key);
        LinkedList<K, V> bucket = table[indice];
        Node<K, V> node = bucket.get(key);
        return node != null ? node.value : null;
    }

    public V getByKey(K key) {
        int indice = hashFunction1(key);
        LinkedList<K, V> bucket = table[indice];
        Node<K, V> node = bucket.get(key);
        return node != null ? node.value : null;
    }
}
