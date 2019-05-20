#include "Light.h"
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include <sstream>
#include <cstring>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"
using namespace std;

//char ldummy;
//char lposX, lposY, lposZ, colorR, colorG, colorB;



Light::Light() {
	position = (glm::vec3)(0, 0, 0);
	color_priv = (glm::vec3) (1, 1, 1);
}

Light::Light(glm::vec3 pos) {
	position = pos;
	color_priv = (glm::vec3) (1, 1, 1);
}

Light::Light(glm::vec3 pos, glm::vec3 color) {
	position = pos;
	color_priv = color;
}

glm::vec3 Light::getPos() {
	return position;
}

glm::vec3 Light::getColor() {
	return color_priv;
}

string Light::toString() {

	string combined;

	combined = (ldummy, lposX, lposY, lposZ, colorR, colorG, colorB);

	return combined;
}
void Light::read(string data) {
	stringstream ss(data);
	//char dummy;
	//char posX, posY, posZ,colorR, colorG, colorB;
	ss >> ldummy;
	ss >> lposZ >> lposY >> lposZ;
	if (ss >> colorR) {
		ss >> colorG >> colorB;
	}
	else {
		colorR = 1;
		colorG = 1;
		colorB = 1;
	}

	Light(glm::vec3(lposX, lposY, lposZ), glm::vec3(colorR, colorG, colorB));
	
}

