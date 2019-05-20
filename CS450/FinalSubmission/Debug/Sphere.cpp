#include "Sphere.h"
#include <cstring>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include <sstream>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"

using namespace std;

char dummy1;
char posX1, posY1, posZ1,radi;


Sphere::Sphere() {
	position = (glm::vec3) (0, 0, 0);
	radiusP = 1.0;
	Material_index = -1;
}

Sphere::Sphere(glm::vec3 center, double radius) {
	position = center;
	radiusP = radius;
}

glm::vec3 Sphere::getCenter(){
	return position;
}

double Sphere::getRadius() {
	return radiusP;
}

string toString() {

	string combined;

	combined = (dummy1, posX1, posY1, posZ1, radi);

	return combined;
}

void Sphere::read(string data) {
	stringstream ss(data);
	
	ss >> dummy1;
	ss >> posX1 >> posY1 >> posZ1 >> radi;
	
	

	Sphere(glm::vec3(posX1, posY1, posZ1), radi);

}

void Sphere::setMaterialIndex(int matIndex) {
	Material_index = matIndex;
};
int Sphere::getMaterialIndex() {
	return Material_index;
};

