#ifndef SCENE_H
#define SCENE_H
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
#include "Material.Cpp"
#include "Light.cpp"
#include "Sphere.cpp"

class Scene {

public:
	Scene();
	~Scene();
	int getLightCnt();
	int getSurfaceCnt();
	int getMaterialCnt();
	float* getImageBuffer();
	int getBufferWidth();
	int getBufferHeight();
	string toString();
	bool loadNFF(string filename, int windowWidth, int windowHeight);

private:
	std::vector<Light*> All_Lights;
	std::vector<Material*> All_Material;
	float* image_buffer;
	int width_buffer, height_buffer;
	glm::vec3 background_color;
	std::vector<Sphere*> All_Spheres;
	void cleanup();

};
#endif // !SCENE_H