package com.familyTree.compositePrototype.search;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
	public static ArrayList<Node> nodes = new ArrayList<>();
	
	
	
	public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x)
	{
		int nodeIndex=-1;
 
		ArrayList<Node> neighbours=new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(x))
			{
				nodeIndex=i;
				break;
			}
		}
 
		if(nodeIndex!=-1)
		{
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if(adjacency_matrix[nodeIndex][j]==1)
				{
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}
	
	public  void dfsUsingStack(int adjacency_matrix[][], Node node)
	{
		Stack<Node> stack=new  Stack<>();
		stack.add(node);
 
		while (!stack.isEmpty())
		{
			Node element=stack.pop();
			if(!element.isVisited())
			{
				System.out.print(element.getData() + " ");
				element.setVisited(true);
			}
 
			ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
				if(n!=null &&!n.isVisited())
				{
					stack.add(n);
				}
			}
		}
	}
	

}
