public class objectArray {
	public static void main(String args[])
	{
		double[] d;
		char[] str;
		String s;
		str = new char[5];
		// 初始化
		str[0]='H';
		str[1]='e';
		str[2]='l';
		str[3]='l';
		str[4]='o';

		d=new double[5];
		for(int n =0;n<d.length;n++)
		{
			d[n] = n+1;
		}
		s = new String(str);
		// int[] k = {1,2,3,4,5};

		System.out.println(str);
		System.out.println(s);
		System.out.println(d);

		for(int n = 0; n<d.length;n++)
		{
			System.out.println(d[n]+" ");
		}
	}
}
