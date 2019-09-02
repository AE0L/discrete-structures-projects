/**
 * Source Code of the class StringMatch
 */
package app.stringmatch;

/**
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * 
 * SECTION: BSCS 2-2
 */
class StringMatch {
	final String content;
	
	StringMatch(String content) {
		this.content = content;
	}
	
	/**
	 * Count the number of occurrences of a pattern in a text using the KMP
	 * algorithm.
	 * 
	 * @param pattern The pattern to be sought
	 * @return number of occurrences
	 */
	int find(String pattern) {
		/* Preprocess the pattern */
		int[] prefix = preProcess(pattern);

		int i = 0,
			j = 0,
			k = 0,
			n = this.content.length(),
			m = pattern.length(),
			num = 0;
			
		/* Loop until there is enough characters for the pattern to compare to
		   in the text. */
		while (n - k >= m) {
			/* Compare the current character in the text(i) to the current
			   character in the pattern(j) */
			while (j < m && this.content.charAt(i) == pattern.charAt(j)) {
				i += 1;
				j += 1;
			}

			/* If comparing reaches the end of pattern, increase the number of
			   match */
			if (j == m)
				++num;

			/* Check prefix to skip some characters */
			if (j > 0 && (prefix[j - 1] > 0)) {
				k = i - prefix[j - 1];
			} else {
				if (i == k)
					i += 1;
				k = i;
			}
			
			/* Resets current character of pattern */
			if (j > 0)
				j = prefix[j - 1];
		}

		return num;
	}
	
	/**
	 * Process the pattern to get it's prefix.
	 * 
	 * @param P The pattern to be processed
	 * @return prefix of pattern
	 */
	private int[] preProcess(String P) {
		int a = 0,
			length = P.length(); 
		int[] Prefix = new int[length];

		Prefix[0] = 0;
		
		for (int b = 1; b < length; b++) {
			while (a > 0 && (P.charAt(a) != P.charAt(b)))
				a = Prefix[a];
			if (P.charAt(a) == P.charAt(b))
				a += 1;
			Prefix[b] = a;
		}
		
		return Prefix;
	}
}
