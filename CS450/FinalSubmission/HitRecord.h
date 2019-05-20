#ifndef HITRECORD_H
#define HITRECORD_H
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include <cstring>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"

class HitRecord {

#define MIN_DISTANCE_T as 0.001 

	public:
		HitRecord();
		HitRecord(double t, glm::vec3 point, glm::vec3 normal, int matIndex);
		double getT();
		glm::vec3 getPoint();
		glm::vec3 getNormal();
		int getMatIndex();
		void setT(double t);
		void setPoint(glm::vec3 point);
		void setNormal(glm::vec3 normal);
		void setMatIndex (int index);


	private:
		double t_value;
		int material_index;
		glm::vec3 intersec_point;
		glm::vec3 normal_point;

};

#endif !HITRECORD_H