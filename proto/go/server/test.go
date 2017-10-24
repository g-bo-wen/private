package main

import (
	"os"
	"log"
)

func main() {
	file, _ := os.Getwd()
	log.Println(file)
}
