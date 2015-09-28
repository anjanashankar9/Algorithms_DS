/*
 * You are given a function rand(a, b) which generates equiprobable random numbers 
 * between [a, b] inclusive. 
 * Generate 3 numbers x, y, z with probability P(x), P(y), P(z) such that 
 * P(x) + P(y) + P(z) = 1 using the given rand(a,b) function.
 * The idea is to utilize the equiprobable feature of the rand(a,b) provided. 
 * Let the given probabilities be in percentage form, for example P(x)=40%, P(y)=25%, P(z)=35%..
 */
public class GenerateRandomNumbers{

		private static int generateEqualProbability(int a, int b){
				return (int) Math.ceil(Math.random() * 100);
		}
		public static int generateRandom(int x, int y, int z, int px, int py, int pz){
				int r = generateEqualProbability(0,100);
				if(r<px)
						return x;
				else if(r<(px+py))
						return y;
				else
						return z;
		}
}