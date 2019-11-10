package com.app.test.tree;

import java.util.List;

public class Node {

	private String id;
	private String parentId;
	private String value;
	private Node parent;

	private List<Node> children;

	public Node(String id, String parentId,String value) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.value=value;
	}

	public Node() {
		super();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", parentId=" + parentId + ", children="
				+ children + "]";
	}

}
