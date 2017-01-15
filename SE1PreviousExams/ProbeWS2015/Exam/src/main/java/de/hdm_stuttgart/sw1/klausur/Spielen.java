package de.hdm_stuttgart.sw1.klausur;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Spielen {


	/**
	 * Bestimme alle Spieler der nächsten Runde zusammen mit ihrem jeweiligen Punktestand.
	 *
	 * @param aktuelleRunde Die Punkte aller Teilnehmer der aktuellen Runde.
	 * @return Die Punktestände aller Teilnehmer, welche mindestens so viele Punkte haben,
	 * wie ihr(e) Nachbar(n) oder null, falls null == aktuelleRunde. Gibt es nur einen Teilnehmer,
	 * so wird dieser zurückgeliefert.
	 */
	public static int[] getTeilnehmerNaechsteRunde(final int[] aktuelleRunde) {
		if (aktuelleRunde == null) return aktuelleRunde;
		List<Integer> nextRound = new ArrayList<>();
		BiFunction<Integer, Integer, Integer> get = (index, len) -> (index < 0) ? len + index : index % len;
		int len = aktuelleRunde.length;
		for (int i = 0; i < len; i++) {
			if (aktuelleRunde[get.apply(i - 1, len)] <= aktuelleRunde[i] &&
					aktuelleRunde[get.apply(i + 1, len)] <= aktuelleRunde[i])
				nextRound.add(aktuelleRunde[i]);
		}
		int[] out = new int[nextRound.size()];
		for (int i = 0; i < nextRound.size(); i++) {
			out[i] = nextRound.get(i);
		}
		return out;
	}
}
