package by.epam.model.comparator;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import by.epam.model.entity.ICar;

//для сортировки по расходу топлива
public final class FuelConsumptionComparator implements Comparator<ICar> {

	@Override
	public int compare(ICar c1, ICar c2) {
		double fuelConsumption1 = c1.getFuelConsumption();
		double fuelConsumption2 = c2.getFuelConsumption();
		if (fuelConsumption1 < fuelConsumption2) {
			return -1;
		}
		if (fuelConsumption1 > fuelConsumption2) {
			return 1;
		}
		return 0;
	}

	@Override
	public Comparator<ICar> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<ICar> thenComparing(Comparator<? super ICar> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<ICar> thenComparing(
			Function<? super ICar, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<ICar> thenComparing(
			Function<? super ICar, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<ICar> thenComparingDouble(
			ToDoubleFunction<? super ICar> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<ICar> thenComparingInt(ToIntFunction<? super ICar> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<ICar> thenComparingLong(ToLongFunction<? super ICar> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
