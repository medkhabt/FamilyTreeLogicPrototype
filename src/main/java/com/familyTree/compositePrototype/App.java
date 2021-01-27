package com.familyTree.compositePrototype;

import com.familyTree.compositePrototype.composite.CoupleComposite;
import com.familyTree.compositePrototype.entity.Couple;
import com.familyTree.compositePrototype.entity.Person;
import com.familyTree.compositePrototype.search.DepthFirstSearch;
import com.familyTree.compositePrototype.search.Node;

public class App {
    public static void main( String[] args ) {
    	
        
    	CoupleComposite a = new Person(1, "a");
    	CoupleComposite b = new Person(2, "b");
    	CoupleComposite c = new Person(3, "c");
    	CoupleComposite d = new Person(4, "d");
    	CoupleComposite e = new Person(5, "e");
    	CoupleComposite f = new Person(6, "f");
    	CoupleComposite g = new Person(7, "g");
    	CoupleComposite h = new Person(8, "h");
    	
    	
    	CoupleComposite couple1 = new Couple(1, a, b); 
    	CoupleComposite couple2 = new Couple(2, a, c, g );
    	
    	
    	
    	((Couple) couple1).addChild(couple2); 
    	((Couple) couple1).addChild(d); 
    	((Couple) couple1).addChild(e);
    	
    	d.setParents(couple1);
    	e.setParents(couple1);
    	couple2.setParents(couple1);
    	
    	((Couple) couple2).addChild(f);
    	((Couple) couple2).addChild(h);
    	
    	
    	f.setParents(couple2);
    	h.setParents(couple2);
    	
    	System.out.println(couple1.show());
    	System.out.println("***********************");
    	
    	System.out.println("Parent of c: " + c.getParents());
    	System.out.println("Parent of h: " + h.getParents());
    	System.out.println("Parent of d: " + d.getParents());
    	System.out.println("Parent of a: " + a.getParents());
    	
    	System.out.println("***********************");
    	
    	System.out.println("d siblings: ");
    	d.getSiblings().forEach((sibling) -> System.out.println("-" + sibling.toString() ));
    	
    	DepthFirstSearch dfsExample = new DepthFirstSearch();
    	
    	Node node40 =new Node(a);
		Node node10 =new Node(b);
		Node node20 =new Node(c);
		Node node30 =new Node(d);
		Node node60 =new Node(e);
		Node node50 =new Node(f);
		Node node70 =new Node(g);
		Node node80 =new Node(h);

 
		DepthFirstSearch.nodes.add(node40);
		DepthFirstSearch.nodes.add(node10);
		DepthFirstSearch.nodes.add(node20);
		DepthFirstSearch.nodes.add(node30);
		DepthFirstSearch.nodes.add(node60);
		DepthFirstSearch.nodes.add(node50);
		DepthFirstSearch.nodes.add(node70);
		DepthFirstSearch.nodes.add(node80);
		int[][] adjacency_matrix1 = new int[DepthFirstSearch.nodes.size()][DepthFirstSearch.nodes.size()]; 
		for(int i = 0; i < DepthFirstSearch.nodes.size(); i++) {
			for(int j = 0; j < DepthFirstSearch.nodes.size(); j++ ) { 
				if(DepthFirstSearch.nodes.get(j).getData().getParents().getRealChild().equals(DepthFirstSearch.nodes.get(i).getData().getRealChild())) {
					adjacency_matrix1[i][j] = 1; 
				}
				else { 
					adjacency_matrix1[i][j] = 0; 
				}
			}
		}
		for(int i = 0 ; i < adjacency_matrix1.length; i++) {
			for(int j = 0; j < adjacency_matrix1.length; j++) {
				System.out.print(adjacency_matrix1[i][j] + " ");
			}
			System.out.println();
			
		}
//		int adjacency_matrix[][] = {
//				{0,1,1,0,0,0,0},  // Node 1: 40
//				{0,0,0,1,0,0,0},  // Node 2 :10
//				{0,1,0,1,1,1,0},  // Node 3: 20
//				{0,0,0,0,1,0,0},  // Node 4: 30
//				{0,0,0,0,0,0,1},  // Node 5: 60
//				{0,0,0,0,0,0,1},  // Node 6: 50
//				{0,0,0,0,0,0,0},  // Node 7: 70
//		};
// 
		
		
 
		System.out.println("The DFS traversal of the graph using stack ");
		dfsExample.dfsUsingStack(adjacency_matrix1, node40);//a
 
 
    	
    }
    
    
    
}
