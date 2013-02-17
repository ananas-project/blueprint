package ananas.lib.blueprint.loader.eom.target;

public class TargetBase implements ITargetNode {

	@Override
	public void setParent(ITargetNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public ITargetNode[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTargetId() {
		return (getClass().getName() + '@' + Integer.toHexString(hashCode()));
	}

}
