package de.jet.tournamentmaker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Player
{
	private String id;

	private String name;
	private int elo;
	private int score;
	private int skippedRounds;
	private boolean active = true;

	public Player()
	{

	}

	public String getId()
	{
		return id;
	}

	public Player setId(String id)
	{
		this.id = id;

		return this;
	}

	public String getName()
	{
		return name;
	}

	public Player setName(String name)
	{
		this.name = name;

		return this;
	}

	public int getElo()
	{
		return elo;
	}

	public Player setElo(int elo)
	{
		this.elo = elo;

		return this;
	}

	public int getScore()
	{
		return score;
	}

	public Player setScore(int score)
	{
		this.score = score;

		return this;
	}

	public int getSkippedRounds()
	{
		return skippedRounds;
	}

	public Player setSkippedRounds(int skippedRounds)
	{
		this.skippedRounds = skippedRounds;

		return this;
	}

	public boolean isActive()
	{
		return active;
	}

	public Player setActive(boolean active)
	{
		this.active = active;

		return this;
	}
}
