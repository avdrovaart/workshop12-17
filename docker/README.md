# Docker omgeving met Java 17
Deze Dockerfile maakt een nieuwe docker container voor je aan met daarop de early access build van [JDK 17](https://jdk.java.net/17/) op geinstalleerd.
## Prerequisites
* [Docker](https://docs.docker.com/get-docker/) (Windows/OS X/Linux)
* Internetverbinding
* Shell (Powershell, Bash, etc.)

## Notes for Windows:
* Gebruik powershell om docker te starten, git-bash of de standaard commandline werkt niet.
* Afhankelijk van de versie van docker op je Windows moet je misschien een extra instelling doen voor de file-sharing. \
  Zie https://stackoverflow.com/questions/60754297/docker-compose-failed-to-build-filesharing-has-been-cancelled \
  Geef dan als directory die gedeeld moet worden de directory van deze git repo op.
* Mogelijk moet je bij het starten ${pwd} gebruiken in je commando i.p.v. $PWD

## How to install
* Clone deze directory naar een lokale map op je PC
* Voer het volgende commando uit in een shell, vanaf **de root van het geclonede project**
```console
docker build . -t java17:latest -f ./docker/Dockerfile
```
```console
podman build . -t java17:latest -f ./docker/Dockerfile
```

* Controleer of de docker beschikbaar is (er zou een image genaamd `java17` moeten zijn)
```console
docker images
```
```console
podman images
```

## How to run
* Start een console in je docker als volgt, wederom vanaf de root van het geclonde project. **Let op:** je dient altijd een absoluut pad mee te geven voor het mounten van volumes in docker. Kijk of `$PWD` werkt voor jouw systeem.
```console
docker run -it -v $PWD:/tmp/workshop --entrypoint bash java17
```
```console
podman run -ti  -v .:/tmp/workshop/ --security-opt label=disable  localhost/java17
```

* Als het goed is staat Java 17 al reeds op je classpath. Dit kun je als volgt controleren
```console
java --version
```
* Verder zijn ook de opdrachten al gemount van de hostfile in de docker container
```console
cd /tmp/workshop/src/opdrachten
```
* Alle wijzigingen die je op je PC maakt, zijn direct beschikbaar in je docker container om te compileren en uit te voeren met Java 17
