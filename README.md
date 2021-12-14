# how to use

```
git clone https://github.com/gramou/vuln-log4j2.git
```

```
cd vuln-log4j2
```

```
sudo docker build . -t vulnlog4j2
```

Start a docker cointainer on port 8080 with localhost binding
```
sudo docker run -it -p 127.0.0.1:8080:8080 vulnlog4j2
```

Open the url http://127.0.0.1:8080

[Vuln Web Server Page](doc/vuln-web-server-page.png)
