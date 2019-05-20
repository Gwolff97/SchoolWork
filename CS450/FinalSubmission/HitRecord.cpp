#include "HitRecord.h"
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

HitRecord::HitRecord() {
	t_value = -1;
	intersec_point = (glm::vec3) (0,0,0);
	normal_point = (glm::vec3) (0,0,1);
	material_index = 0;

};

HitRecord::HitRecord(double t, glm::vec3 point, glm::vec3 normal, int matIndex) {
	t_value = t;
	intersec_point = point;
	normal_point = normal;
	material_index = matIndex;
};

double HitRecord::getT() {
	return t_value;
};

glm::vec3 HitRecord::getPoint() {
	return intersec_point;
}

glm::vec3 HitRecord::getNormal() {
	return normal_point;
};

int HitRecord::getMatIndex() {
	return material_index;
};

void HitRecord::setT(double t) {
	t_value = t;
};

void HitRecord::setPoint(glm::vec3 point) {
	intersec_point = point;
};

void HitRecord::setNormal(glm::vec3 normal) {
	normal_point = normal;
};

void HitRecord::setMatIndex(int index) {
	material_index = index;
};

