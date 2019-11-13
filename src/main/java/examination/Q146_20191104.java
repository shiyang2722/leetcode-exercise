package examination;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/4.
 */
public class Q146_20191104 {
    //cache.put(1, 1);
    //cache.put(2, 2);
    //cache.get(1);       // 返回  1
    //cache.put(3, 3);    // 该操作会使得密钥 2 作废
    //cache.get(2);       // 返回 -1 (未找到)
    //cache.put(4, 4);    // 该操作会使得密钥 1 作废
    //cache.get(1);       // 返回 -1 (未找到)
    //cache.get(3);       // 返回  3
    //cache.get(4);       // 返回  4
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));           //1
//        cache.put(1, 1);    // 该操作会使得密钥 2 作废
//        cache.put(4, 1);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

class LRUCache {

    int capacity;

    Map<Integer, CEntry> map = new HashMap<>(capacity);
    CEntry head = new CEntry(0, 0);
    CEntry tail = new CEntry(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CEntry entry = map.get(key);
            popToLast(entry);
            return entry.getData();
        }
        return -1;
    }

    private void popToLast(CEntry entry) {
        CEntry preEntry = entry.pre;
        CEntry nextEntry = entry.next;
        preEntry.next = nextEntry;
        nextEntry.pre = preEntry;
        toLast(entry);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CEntry existed = map.get(key);
            if (value != existed.getData()) {
                existed.setData(value);
            }
            popToLast(existed);
        } else {
            CEntry entry = new CEntry(key, value);
            if (map.size() == capacity) {
                CEntry first = removeFirst();
                map.remove(first.getKey());
            }
            map.put(key, entry);
            toLast(entry);
        }
    }

    private CEntry removeFirst() {
        CEntry first = head.next;
        CEntry second = first.next;
        head.next = second;
        second.pre = head;
        return first;
    }

    private void toLast(CEntry entry) {
        CEntry last = tail.pre;

        last.next = entry;
        entry.pre = last;
        entry.next = tail;
        tail.pre = entry;
    }

    private class CEntry {

        int key;
        int data;

        CEntry head;
        CEntry tail;

        CEntry pre;
        CEntry next;

        public CEntry(int key, int data) {
            this.key = key;
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public CEntry getHead() {
            return head;
        }

        public void setHead(CEntry head) {
            this.head = head;
        }

        public CEntry getTail() {
            return tail;
        }

        public void setTail(CEntry tail) {
            this.tail = tail;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
