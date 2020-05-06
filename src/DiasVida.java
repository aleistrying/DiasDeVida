import java.util.Calendar;
import java.util.TimeZone;

public class DiasVida
{
	// private String fechaNacimiento ="01/01/1000";
	private int Dia;
	private int Mes;
	private int Ano;
	private int DiaActual;
	private int MesActual;
	private int AnoActual;
	private int Bisiestos;// por si el usuario quiere saber
	private int DiasEnAno = 365;
	private double AnosVividos;
	private int DiasVividos;

	public boolean fechaNac(String s)
	{

		String[] fecha = s.trim().split("/");
		int len = fecha.length;
		if (len == 3)
		{
			for (int i = 0; i < 3; i++)
			{
				len = fecha[i].length();
				if (len != 1 && len != 2 && len != 4)
				{
					return false;
				} else if (i == 2 && (len == 2 || len == 4))
				{
					Dia = Integer.parseInt(fecha[0]);
					Mes = Integer.parseInt(fecha[1]);
					Ano = Integer.parseInt(fecha[2]);
					// System.out.println(Dia + " " + Mes + " " +Ano);
					Calcular();
					return true;
				}
			}
		}

		return false;
	}

	private void getFechaHoy(String tz)
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(tz));
		long zoneTime = calendar.getTime().getTime();

		long zonaAlt = zoneTime + TimeZone.getTimeZone(tz).getRawOffset();
		calendar = Calendar.getInstance(TimeZone.getTimeZone(tz));
		calendar.setTimeInMillis(zonaAlt);

		// Calendar calendar = GregorianCalendar.getInstance();
		// calendar.setTime(date);
		DiaActual = calendar.get(Calendar.DAY_OF_MONTH);
		MesActual = calendar.get(Calendar.MONTH);
		AnoActual = calendar.get(Calendar.YEAR);

	}

	private int MesADias(int Meses, int Anos, int InicioCuenta)
	{
		int Total = 0;
		boolean inicio = true;
		Meses += InicioCuenta;
		int rep = Meses / 12;
		int res = Meses % 12;
		int DiasT, Dia_Feb, Dia_Par, Dia_Imp;

		for (int k = 0; k <= rep; k++)
		{

			if (k == rep)
			{
				Meses = res;
			} else
			{
				Meses = 12;
			}

			DiasT = 0;
			DiasEnAno = 365;
			Dia_Feb = 28;
			Dia_Par = 30;
			Dia_Imp = 31;/*
							 * if(Meses >= 2){ DiasT += 28; }
							 */
			// dp(InicioCuenta,Total);
			// dp(Anos,Meses);
			for (int i = InicioCuenta; i <= Meses; i++)
			{
				if (i != 2)
				{
					if (i >= 8)
					{
						Dia_Par = 31;
						Dia_Imp = 30;

					}

					if (i % 2 == 0)
					{
						// dp(Dia_Par,i);
						DiasT += Dia_Par;
					} else
					{
						DiasT += Dia_Imp;
						// dp(Dia_Imp,i);
					}
				} else
				{
					if (((Anos % 4 == 0 && Anos % 100 != 0) || Anos % 400 == 0) && Meses != 0)
					{
						Dia_Feb++;
						setBisiestos(getBisiestos() + 1);
						DiasEnAno++;
					}
					// dp(Dia_Feb,i);
					DiasT += Dia_Feb;

				}

			}
			if (inicio)
			{
				inicio = false;
				InicioCuenta = 1;
			}
			AnosVividos += ((double) DiasT / DiasEnAno);
			// dp(AnosVividos,DiasVividos);
			Anos++;
			Total += DiasT;
		}
		return Total;

	}

	private void Calcular()
	{
		getFechaHoy("EST");
		/*
		 * dp(DiaActual,Dia); dp(MesActual,Mes); dp(AnoActual,Ano);
		 * dp((MesActual-Mes),(AnoActual-Ano)* 12);
		 */
		AnosVividos = 0;
		setBisiestos(0);
		DiasVividos = ((DiaActual - Dia) + MesADias(((MesActual - Mes) + (AnoActual - Ano) * 12), Ano, Mes));

	}

	/*
	 * private void dp(double a, int b){ System.out.println(a + " " + b); }
	 */
	public double Edad()
	{
		return AnosVividos;
	}

	public int DiasVividos()
	{
		return DiasVividos;
	}

	public int getBisiestos()
	{
		return Bisiestos;
	}

	private void setBisiestos(int bisiestos)
	{
		Bisiestos = bisiestos;
	}

}
