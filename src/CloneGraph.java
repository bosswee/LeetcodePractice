import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wee on 2015/5/8.
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:思路：
 图的复制，基于BFS，用到了Hashtable来去重

 参考：
 图的遍历有两种方式，BFS和DFS

 这里使用BFS来解本题，BFS需要使用queue来保存neighbors

 但这里有个问题，在clone一个节点时我们需要clone它的neighbors，而邻居节点有的已经存在，有的未存在，如何进行区分？

 这里我们使用Map来进行区分，Map的key值为原来的node，value为新clone的node，当发现一个node未在map中时说明这个node还未被clone，

 将它clone后放入queue中处理neighbors。

 使用Map的主要意义在于充当BFS中Visited数组，它也可以去环问题，例如A--B有条边，当处理完A的邻居node，然后处理B节点邻居node时发现A已经处理过了

 处理就结束，不会出现死循环！

 queue中放置的节点都是未处理neighbors的节点！！！！



 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
       List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();//BFS的queue
        //hashtable<node,clonenoe>
        Hashtable<UndirectedGraphNode,UndirectedGraphNode> ht = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();//去重

        UndirectedGraphNode retClone = new UndirectedGraphNode(node.label);//根节点的复制
        ht.put(node,retClone);//把根节点和复制品放入ht
        queue.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.remove();//处理当前对象
            UndirectedGraphNode curClone = ht.get(cur);//当前处理对象的复制品，必定在ht里，因为在前面的neighbor已经被创建

            List<UndirectedGraphNode> neighbors = cur.neighbors;//得到当前原始对象的相邻节点
            for (int i = 0; i < neighbors.size(); i++) {//对每一个neighbor进行判断，因为有的neighbor已经被复制，有的没有
                UndirectedGraphNode neighbor = neighbors.get(i);
                if(ht.containsKey(neighbor)){//之前被复制过的neighbor
                    UndirectedGraphNode neighborClone = ht.get(neighbor);//直接从ht中取出neighborclone
                    curClone.neighbors.add(neighborClone);//给curClone添加复制的neighbor
                }else{//没复制过，就新建neighBorClone
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
                    curClone.neighbors.add(neighborClone);
                    ht.put(neighbor,neighborClone);//存储到ht里
                    queue.add(neighbor);//添加到队列里为了将来的遍历
                }
            }
        }
            return retClone;
        }

    //DFs

}
