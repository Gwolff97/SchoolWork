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
#include "HitRecord.h"

using namespace std;

Sphere::Sphere() {
	position = (glm::vec3) (0, 0, 0);
	radiusP = 1.0;
	Material_index = -1;
}

Sphere::Sphere(glm::vec3 center, double radius) {
	position = center;
	radiusP = radius;
}

glm::vec3 Sphere::getCenter() {
	return position;
}

double Sphere::getRadius() {
	return radiusP;
}

string Sphere::toString() {

	string combined;

	combined = (spdummy1, spposX1, spposY1, spposZ1, spradi);

	return combined;
}

void Sphere::read(string data) {
	stringstream ss(data);

	ss >> spdummy1;
	ss >> spposX1 >> spposY1 >> spposZ1 >> spradi;



	Sphere(glm::vec3(spposX1, spposY1, spposZ1), spradi);

}

void Sphere::setMaterialIndex(int matIndex) {
	Material_index = matIndex;
};
int Sphere::getMaterialIndex() {
	return Material_index;
};

bool Sphere::getIntersection(glm::vec3 rayStart, glm::vec3 rayDir, HitRecord &record) {

	//Intersection code
	double radisquare = radiusP * radiusP;
	float a = glm::dot(rayDir, rayDir);
	float b = 2.0 * glm::dot(rayDir, rayStart - position);
	float c = glm::dot(rayStart - position, rayStart - position) - radisquare;
	float discriminant = (b*b - (4 * a*c));
	float discsqrt = glm::sqrt(discriminant);
	float low_t = (-b + discriminant / (2 * a));

	if (discriminant < 0)
		return false;
	
	record.setT(low_t);
	record.setMatIndex(Material_index);
	record.setPoint(rayStart);
	record.setNormal(rayDir);

	return true;
};
