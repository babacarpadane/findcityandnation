<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nome utente</title>
</head>
<body>
  <form name="username" >	
    <p>Ciao ${usernamejsp}<br> <!-- sessionScope. -->
    Inserisci username <input type="text" name="username"><br>
    <input type="submit" name="login" value="Login" formaction="sessionservlet"	></p>		 
  </form>
  	
  <form name="find_city">	
  	<p><strong>Cerca città</strong><br>
  	Inserisci nome città <input type="text" name="name"> <br>
  	<input type="submit" name="trova_citta" value="Cerca città" formaction="cityservlet"></p>	
  </form>
  
  <form name="find_nation">	
  	<p><strong>Cerca nazione</strong><br>
  	Inserisci nazione <input type="text" name="name"><br>
  	Inserisci continente <input type="text" name="continent"><br>
  	<input type="submit" name="trova_nazione" value="Cerca nazione" formaction="nationservlet"></p>
  </form>
  
  <p>Città trovata: id= ${ID}, nome= ${nome}, codice nazione=${countryCode}, distretto= ${distretto}, popolazione= ${population}</p>  	
  <p>Nazione trovata: code= ${code}, nome= ${nome_n}, continente=${countinent}, popolazione= ${population_n}, superficie= ${surface}</p>
  	
</body>
</html>