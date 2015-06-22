package BFSAndDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Wee on 2015/5/15.
 *
 * http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
 *
 *
 * here are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have
 finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

 This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore
 it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.

 Topological sort could also be done via BFS.
解法2：下面我们来看DFS的解法，也需要建立有向图，还是用二维数组来建立，和BFS不同的是，我们像现在需要一个一维数组visit来记录访问状态，
 大体思路是，先建立好有向图，然后从第一个门课开始，找其可构成哪门课，暂时将当前课程标记为已访问，然后对新得到的课程调用DFS
 递归，直到出现新的课程已经访问过了，则返回false，没有冲突的话返回true，然后把标记为已访问的课程改为未访问
 */
public class CourseSchedule {
    //本质是判断有向图中有没有闭环，DFS

    static class Course {
        //建立课程类
        private boolean vis;
        private boolean done;
        private ArrayList<Course> pre = new ArrayList<Course>();

        void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        boolean isCyclic() {
            if (done) {
                return false;
            }
            if (vis) {
                return true;
            }
            vis = true;

            for (Course preCourse : pre) {
                if (preCourse.isCyclic()) {
                    return true;
                }
            }

            vis = false;
            done = true;
            return false;
        }
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立有向图
        Course clist[] = new Course[numCourses];

        for (int i = 0; i < numCourses; i++) {
            clist[i] = new Course();
        }

        for (int[] couple : prerequisites) {
            Course c1 = clist[couple[0]];
            Course c2 = clist[couple[1]];
            c1.addPre(c2);
        }
        //判断闭环
        for (int i = 0; i < numCourses; i++) {
            if (clist[i].isCyclic()) {
                return false;
            }
        }

        return true;
    }

    //Todo:待研究：BFS,拓扑排序
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses, prerequisites);
        return g.topoGraph();
    }

    class Graph {
        private int n;
        private HashMap<Integer, ArrayList<Integer>> alledges = new HashMap<Integer, ArrayList<Integer>>();
        private int[] indegree;
        private int[] outdegree;

        //构造图结构，由于只需要构建拓扑结构，因此只需要保存入度及出度，这里需要注意一点的是
        //哪一个节点是源节点，哪一个节点是目标节点
        public Graph(int nvatex, int[][] edges) {
            this.n = nvatex;
            this.indegree = new int[nvatex];
            this.outdegree = new int[nvatex];
            for (int i = 0; i < edges.length; i++) {
                if (alledges.containsKey(edges[i][1])) {
                    ArrayList<Integer> tmp = alledges.get(edges[i][1]);
                    tmp.add(edges[i][0]);
                    alledges.put(edges[i][1], tmp);
                } else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(edges[i][0]);
                    alledges.put(edges[i][1], tmp);
                }
                indegree[edges[i][0]]++;
                outdegree[edges[i][1]]++;
            }
        }

        public boolean topoGraph() {
            int count = 0;
            LinkedList<Integer> queen = new LinkedList<Integer>();
            //将所有入度为0的点入队
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0)
                    queen.offer(i);
            }

            //构建拓扑结构图
            while (!queen.isEmpty()) {
                int ver = queen.poll();
                count++;
                ArrayList<Integer> tmp = alledges.get(ver);
                if (tmp != null) {
                    //对该节点所有邻居节点的入度进行-1，然后判断是否为0,
                    //如果为0,则应该入队列
                    for (int num : tmp) {
                        indegree[num]--;
                        if (indegree[num] == 0)
                            queen.offer(num);
                    }
                }
            }

            //如果最后拓扑结构中的节点数等于图中的节点数，则不存在环路
            //否则则存在环路
            if (n == count)
                return true;
            else
                return false;

        }

    }
}
