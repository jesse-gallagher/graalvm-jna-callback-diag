void callme(void (*ptr)(long long somearg)) {
    (*ptr)(3);
}

int callmebasic(int somearg) {
	return somearg+1;
}
