#include "Material.h"
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
//#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
//#include "glm/gtx/string_cast.hpp"
using namespace std;

char dummy2;
char red1, green1, blue1, Kdr, Ksr, Shiner, T, index_of_refraction;

Material::Material() {
	diffuse_color = (glm::vec3) (1, 1, 1);
	Kd = 1.0;
	Ks = 1;
	shininess = 1.0;
	transmittance = 0.0;
	refraction_index = 1.0;
};

Material::Material(glm::vec3 diffuse_colorr, float Kdm, float Ksm, float shinerm, float Tm, float index_of_refraction) {
	diffuse_color = diffuse_colorr;
	Kd = Kdm;
	Ks = Kdm;
	shininess = shinerm;
	transmittance = Tm;
	refraction_index = index_of_refraction;
};

glm::vec3 Material::getColor() {
	return diffuse_color;
};

float Material::getKd() {
	return Kd;
};

float Material::getKs() {
	return Ks;
};

float Material::getShine() {
	return shininess;
};

float Material::getTransmittance() {
	return transmittance;
};

float Material::getIndexRefraction() {
	return refraction_index;
};

void Material::read(std::string data) {
	stringstream ss(data);

	ss >> dummy2;
	ss >> red1 >> green1 >> blue1 >> Kdr >> Ksr >> Shiner >> T >> index_of_refraction;

	Material(glm::vec3(red1, green1, blue1), Kdr, Ksr, Shiner, T, index_of_refraction);
};

std::string Material::toString() {
	string combined;
	combined = (dummy2, red1, green1, blue1, Kdr, Ksr, Shiner, T, index_of_refraction);
	return combined;
};