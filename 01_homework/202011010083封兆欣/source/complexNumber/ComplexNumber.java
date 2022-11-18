/**
 * @author Feng Zhaoxin
 */
package complexNumber;

public class ComplexNumber {

	private double realPart;
	private double iPart;

	public ComplexNumber() {
		realPart = 0;
		iPart = 0;
	}

	public ComplexNumber(double r, double i) {
		realPart = r;
		iPart = i;
	}

	public double getRealPart() {
		return realPart;
	}

	public double getIPart() {
		return iPart;
	}

	public void setRealPart(double d) {
		realPart = d;
	}

	public void setIPart(double d) {
		iPart = d;
	}

	public ComplexNumber complexAdd(ComplexNumber c) {
		c.iPart = this.iPart + c.iPart;
		c.realPart = this.realPart + c.realPart;
		return c;
	}

	public ComplexNumber complexAdd(double c) {
		this.realPart = this.realPart + c;
		return this;
	}

	public ComplexNumber complexMinus(ComplexNumber c) {
		c.iPart = this.iPart - c.iPart;
		c.realPart = this.realPart - c.realPart;
		return c;
	}

	public ComplexNumber complexMinus(double c) {
		this.realPart = this.realPart - c;
		return this;
	}

	public ComplexNumber complexMulti(ComplexNumber c) {
		ComplexNumber result = new ComplexNumber();
		result.iPart = this.iPart * c.realPart + this.realPart * c.iPart;
		result.realPart = this.realPart * c.realPart - this.iPart * c.iPart;
		return result;
	}

	public ComplexNumber complexMulti(double c) {
		ComplexNumber result = new ComplexNumber();
		result.realPart = this.realPart * c;
		result.iPart = this.iPart * c;
		return result;
	}

	@Override
	public String toString() {
		if (realPart == 0 && iPart == 0)
			return "0";
		else if (iPart == 0) {
			return "data:" + this.realPart;
		} else if (realPart == 0) {
			return "data:" + this.iPart + "i";
		} else if (iPart > 0) {
			return "data:" + this.realPart + "+" + this.iPart + "i";
		} else {
			return "data:" + this.realPart + this.iPart + "i";
		}

	}

}
