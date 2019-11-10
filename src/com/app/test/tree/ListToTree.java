package com.app.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Tree to be created 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class ListToTree {

	public static void main(String[] args) {

		List<Node> nodes = new ArrayList<>();

		nodes.add(new Node("1", "0", "123"));
		nodes.add(new Node("2", "0", "123"));
		nodes.add(new Node("3", "0", "123"));
		nodes.add(new Node("4", "0", "123"));
		nodes.add(new Node("5", "1", "123"));
		nodes.add(new Node("6", "3", "123"));
		nodes.add(new Node("7", "2", "123"));
		nodes.add(new Node("8", "2", "123"));
		nodes.add(new Node("9", "3", "123"));
		nodes.add(new Node("10", "9", "123"));
		nodes.add(new Node("11", "10", "123"));
		nodes.add(new Node("12", "11", "123"));
		nodes.add(new Node("13", "8", "123"));
		nodes.add(new Node("14", "13", "123"));
		nodes.add(new Node("15", "14", "123"));
		nodes.add(new Node("16", "15", "123"));
		nodes.add(new Node("17", "15", "123"));
		nodes.add(new Node("18", "4", "123"));
		nodes.add(new Node("19", "4", "123"));
		nodes.add(new Node("20", "12", "123"));
		nodes.add(new Node("21", "12", "123"));
		nodes.add(new Node("22", "5", "123"));
		nodes.add(new Node("23", "19", "123"));
		nodes.add(new Node("24", "19", "123"));
		nodes.add(new Node("25", "22", "123"));
		

		createTree(nodes);
	}

	private static void createTree(List<Node> nodes) {

		Map<String, Node> mapTmp = new HashMap<>();
		Map<String, List<Node>> grpNodeMap = new HashMap<>();
		for (Node node : nodes) {
			mapTmp.put(node.getId(),node);
		}
		for (Node node : nodes) {
			List<Node> nodeLst=new ArrayList<Node>();
			if(grpNodeMap.containsKey(node.getParentId())) {
				List<Node> exitNodeLst=grpNodeMap.get(node.getParentId());
				exitNodeLst.add(node);
				grpNodeMap.put(node.getParentId(), exitNodeLst);	
			}else {
				nodeLst.add(node);
				grpNodeMap.put(node.getParentId(), nodeLst);				
			}
		}
		//System.out.println(grpNodeMap);
		Map<String, Node> tmpMap = new HashMap<>();
		Set<String> idsSet=grpNodeMap.keySet();
		for (String id : idsSet) {
			if(!id.equalsIgnoreCase("0")) {
				if(mapTmp.containsKey(id)){
					Node node=mapTmp.get(id);
					node.setChildren(grpNodeMap.get(id));
					tmpMap.put(id,node);
				}
			}
		}
		List<Node> nodeLst=new ArrayList<Node>();
		for (String id : idsSet) {
			if(id.equalsIgnoreCase("0")) {
				List<Node> nodesLst=grpNodeMap.get(id);
				for(Node nde:nodesLst) {
					Node nd=tmpMap.get(nde.getId());
					nde.setParent(nd);
					nodeLst.add(nde);
				}
			}
		}		
		System.out.println(nodeLst);
	}
}
