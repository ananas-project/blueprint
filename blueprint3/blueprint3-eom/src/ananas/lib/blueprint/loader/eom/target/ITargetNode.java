package ananas.lib.blueprint.loader.eom.target;

public interface ITargetNode {

	void setParent(ITargetNode node);

	ITargetNode getParent();

	ITargetNode[] getChildren();

	String getTargetId();

}
