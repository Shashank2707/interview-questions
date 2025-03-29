package com.test.lld.question.tictactoegame.player;

import com.test.lld.question.tictactoegame.playingsymbol.PlayingSymbol;

public class Players {

	private String name;
	private PlayingSymbol playingSymbol;
	
	
	public Players(String name, PlayingSymbol playingSymbol) {
		this.name = name;
		this.playingSymbol = playingSymbol;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public PlayingSymbol getPlayingSymbol() {
		return playingSymbol;
	}


	public void setPlayingSymbol(PlayingSymbol playingSymbol) {
		this.playingSymbol = playingSymbol;
	}
}
