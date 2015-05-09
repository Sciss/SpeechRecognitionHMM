/*
  Please feel free to use/modify this class. 
  If you give me credit by keeping this information or
  by sending me an email before using it or by reporting bugs , i will be happy.
  Email : gtiwari333@gmail.com,
  Blog : http://ganeshtiwaridotcomdotnp.blogspot.com/ 
 */
package org.ioe.tprsa.audio.feature;

/**
 * Performs an inverse Fourier Transform .<br>
 * We use DCT because there is only real coefficients.
 * 
 * @author Ganesh Tiwari
 * @author Hanns Holger Rutz
 */
public class DCT {

	/**
	 * number of mfcc coefficients
	 */
	final int numCoefficients;
	/**
	 * number of Mel Filters
	 */
	final int M;

	/**
	 * @param numCoefficients
	 *            length of array, i.e., number of features
	 * @param M
	 *            number of Mel Filters
	 */
	public DCT(int numCoefficients, int M) {
		this.numCoefficients = numCoefficients;
		this.M = M;
	}

	public double[] perform(double y[]) {
		final double cepc[] = new double[numCoefficients];
		// perform DCT
		for (int n = 1; n <= numCoefficients; n++) {
			for (int i = 1; i <= M; i++) {
				cepc[n - 1] += y[i - 1] * Math.cos(Math.PI * (n - 1) / M * (i - 0.5));
			}
		}
		return cepc;
	}
}
