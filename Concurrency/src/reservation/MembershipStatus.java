package reservation;
public enum MembershipStatus
{
	STANDARD(1),
	GOLD(2),
	PLATINUM(3);

	private int priority;

	MembershipStatus(int priority)
	{
		this.priority = priority;
	}

	public int getPriority()
	{
		return priority;
	}
}