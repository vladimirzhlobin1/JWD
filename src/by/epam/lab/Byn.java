package by.epam.lab;

public class Byn implements Comparable<Byn> {
public int costOfObject;

public Byn() {
}

public Byn(int costOfObject) {
	this.costOfObject = costOfObject;
}
public static String format(int a) {
    return String.format("%d.%02d", a / 100, a % 100);
}
@Override
public String toString() {
	return "costOfObject = " + format(costOfObject);
}
public int getcostOfObject() {
    return (int) costOfObject;
}


@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null) {
		return false;
	}
	if (getClass() != obj.getClass()) {
		return false;
	}
	
	Byn other = (Byn) obj;
	return costOfObject == other.costOfObject;
}

@Override
public int compareTo(Byn o) {
	return 0;
}
}