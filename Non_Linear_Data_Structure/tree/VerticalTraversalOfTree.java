package tree;
import java.util.*;

public class VerticalTraversalOfTree {
    

class Node {

    Node left;
    Node right;
    int data;

    Node(int data){
        this.data=data;

    }
}
class Values{
    int max;
    int min;
    Values(int min,int max){
        this .min=min;
        this.max=max;

    }
}
ArrayList<Integer> list=new ArrayList<>();

public static void getTopView(Node root,Values values,int level,ArrayList<Integer> list){
    if(root==null)
    return;

    getTopView(root.left,values,level-1,list);

    if(level>values.max)
    {
        list.add(root.data)
        values.max=level;
    }
    if (level<values.min) {
        list.add(root.data);

        values.min=level;

    }
    getTopView(root.right, values, level+1,list);


}

public ArrayList <Integer> bottomView(Node root)
{
    // Code here
    ArrayList <Integer> list =new ArrayList<>();

    int level =0;

    TreeMap<Integer,Integer>map=new TreeMap<>();

     bottom(root,level,map);
     for(int key:map.keySet())
     {
         list.add(map.get(key));
     }
     

return list ;}

private void bottom(Node root, int level, TreeMap<Integer, Integer> map) {
    if(root==null)
    return ;
    bottom(root.left, level-1, map);
    bottom(root.right, level+1, map);
    if(!map.containsKey(level))
    {
        map.put(level, root.data);
        System.out.println(root.data);
    }
    return;
    
    
}
}


