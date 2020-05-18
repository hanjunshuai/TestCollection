# 1、Map介绍
## 1.1、Map 和 Collection 区别
    Map 集合特点
     将键映射到的对象，一个映射不能包含重复的键，每个键最多只能映射到一个值
    Map 和 Collection 的区别
     a、Map 集合存储元素是成对出现的，Map 的键是唯一的，值是可以重复的
     b、Collection 集合存储元素的单独出现的，Collection 的儿子 Set 是唯一的，List 是可以重复
     
     要点：a、Map集合的数据结构针对键有效，跟值无关。
          b、Collection 集合的数据结构针对元素有效。
## 1.2 Map 的功能
    Map 集合的功能概述：
        1、添加功能
            V put (K key,V value): 添加元素
                如果键是第一次存储，就直接存储元素，返回null
                如果键不是第一次存在，就用值把以前的值替换，返回以前的值
        2、删除功能
            void clear():移除所有的键值对元素
            V remove(Object key):根据键删除值，并把值返回
        3、判断功能
            boolean containsKey(Object key):判读集合是否包含指定的键
            boolean containsValue(Object value):判断集合是否包含指定的值
            boolean isEmpty():判断集合是否为空
        4、获取功能
            Set<Map,Entry<K key, V value>> entrySet():返回的是键值对对象的集合
            V get(Object key):根据键获取值
            Set<K> keySet():获取集合中所有键的集合
            Collection<V> values():获取集合中所有值的集合
        5、长度功能
            int size():返回集合中键值对的对数