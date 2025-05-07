#!/bin/bash

echo "Iniciando requisições para http://localhost:8080/whoami/whoami a cada 1 ms..."
echo "Pressione Ctrl+C para parar."

while true
do
  echo -n "$(date +'%H:%M:%S.%3N') - "
    curl -s http://localhost:8080/whoami/whoami
  echo -e "\n"

  sleep 0.001
done
