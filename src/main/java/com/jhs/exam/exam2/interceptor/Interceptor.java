package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.http.Rq;

public abstract class Interceptor {
	abstract public boolean runBeforeAction(Rq rq);
}
