<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nome utente</title>
</head>
<body>
	<br>
	<form name="username">

		Ciao ${sessionScope.usernamejsp}<br> Inserisci username <!--  --><input
			type="text" name="username"><br> <br> <strong>Cerca
			citt�</strong><br> Inserisci nome citt� <input type="text" name="name"><br>
		<input type="submit" name="invia" value="cerca citt�"
			formaction="servletcity"><br> <br> <strong>Cerca
			nazione</strong><br> Inserisci nazione <input type="text" name="name"><br>
		Inserisci continente <input type="text" name="continent"><br>
		<input type="submit" name="invia" value="cerca nazione"
			formaction="servnomecontinente"><br>

	</form>
<br>
	Citt� trovata: id= ${ID}, nome= ${nome}, codice nazione=
	${countryCode}, distretto= ${distretto}, popolazione= ${population}<br><br>
	
	Nazione trovata: code= ${code}, nome= ${nome_n}, continente=
	${countinent}, popolazione= ${population_n}, superficie= ${surface}
</body>
</html>