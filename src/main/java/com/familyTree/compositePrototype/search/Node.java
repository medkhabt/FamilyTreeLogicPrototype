package com.familyTree.compositePrototype.search;

import com.familyTree.compositePrototype.composite.CoupleComposite;

public class Node {
		private CoupleComposite data; 
		private boolean visited; 
		
		public Node(CoupleComposite data) { 
			this.data = data; 
		}

		public CoupleComposite getData() {
			return data;
		}

		public void setData(CoupleComposite data) {
			this.data = data;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		
		
	
}
