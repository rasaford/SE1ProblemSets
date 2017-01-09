package de.max.chapter10.nonsense;

public class Nonsense {

	private static final String[] ADJECTIVES = { "red", "green", "yellow", "gray", "solid", "fierce", "friendly",
			"cowardly", "convenient", "foreign", "national", "tall", "short", "metallic", "golden", "silver", "sweet",
			"nationwide", "competitive", "stable", "municipal", "famous" };

	private static final String[] THINGS = { "elephant", "bowl", "brick", "spoon", "bunny", "tangerine", "duck",
			"bottle", "road", "fork", "physicist", "griffon", "hat", "key", "knife", "lawyer", "llama", "manual",
			"meat", "monitor", "mouse", "dog", "paper", "pear", "pen", "pencil", "phone", "glass", "planet", "potato",
			"engineer", "salad", "shoe", "slipper", "soup", "building", "star", "steak", "table", "terminal",
			"treehouse", "truck", "cake", "window" };

	private static final String[] VERBS = { "plans cease fire against", "expected to sell", "expected to buy",
			"speaks to", "leases", "signs partnership with", "advances towards", "meets with", "seen with", "sells",
			"is authorized to sell", "signs truce with", "converts into", "buys", "rents", "allegedly speaks to",
			"collapses on", "invests on", "warns", "threatens", "reported to have met with", "now manages",
			"starts war with", "accuses", "becomes", "works together with" };

	private SequenceGenerator seqence;
	
	public Nonsense(SequenceGenerator seqence)
	{
		this.seqence = seqence;
	}

	public String get()
	{
		
		StringBuffer string = new StringBuffer();
		
		string.append("The ");
		string.append(choose(ADJECTIVES));
		string.append(" ");
		string.append(choose(THINGS));
		string.append(" ");
		string.append(choose(VERBS));
		string.append(" a ");
		string.append(choose(THINGS));
		string.append(".");
		
		return string.toString();
	}
	
	private String choose(String[] strings)
	{
		return strings[seqence.getNext(0, strings.length)];
	}
}
