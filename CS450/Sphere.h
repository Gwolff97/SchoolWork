#ifndef SPHERE_H
#define SPHERE_H
#include <cstring>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"
#include "HitRecord.h"


class Sphere {
public:
	Sphere();
	Sphere(glm::vec3 center, double radius);
	glm::vec3 getCenter();
	double getRadius();
	std::string toString();
	void read(std::string data);
	void setMaterialIndex(int matIndex);
	int getMaterialIndex();
	bool getIntersection(glm::vec3 rayStart, glm::vec3 rayDir, HitRecord &record);


private:
	glm::vec3 position;
	double radiusP;
	int Material_index;
	char spdummy1;
	char spposX1, spposY1, spposZ1, spradi;
};

#endif // !SPHERE_H

