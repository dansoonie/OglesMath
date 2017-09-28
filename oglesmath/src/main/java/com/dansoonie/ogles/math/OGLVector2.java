package com.dansoonie.ogles.math;

import android.util.Log;

/**
 * Created by dansoonie on 17/9/28/.
 */

/**
 * Represents a 2 component vector. The component names are x and y respectively.
 */
public class OGLVector2 {
  public static final String TAG = OGLVector2.class.getName(); // Tag for logging

  public static final int NUM_COMPONENTS = 2; // Number of components

  // Array index for each component
  public static final int X = 0;
  public static final int Y = 1;

  // The components for the vector
  public final float x;
  public final float y;

  protected float[] mArray;

  protected OGLVector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Create a new vector
   * Each component is initialized to 0.
   * @return A new vector with each component initialized to 0.
   */
  public static OGLVector2 make() {
    return new OGLVector2(0, 0);
  }

  /**
   * Create a new vector
   * Each component initialized with the given parameters.
   * @param x Value for x component
   * @param y Value for y component
   * @return A new vector with each component initialized with the given parameters
   */
  public static OGLVector2 make(float x, float y) {
    return new OGLVector2(x, y);
  }

  /**
   * Get an array containing values for all the components of the vector. The order of values for
   * each component in the array is x and y.
   * WARNING: The values inside the array is mutable and can cause undesirable side effects. Use
   * debug mode to get warnings about it.
   * @return An array containing values for all the components of the vector
   */
  public float[] toArray() {
    if (mArray == null) {
      mArray = new float[NUM_COMPONENTS];
      mArray[X] = x;
      mArray[Y] = x;
    } else {
      if (OGLMath.isDebugMode()) {
        if (mArray[X] != x && mArray[Y] != y) {
          Log.w(TAG, "Values of the array has been altered and does not represent vector component values !!!");
        }
      }
    }
    return mArray;
  }

  /**
   * Get the length(magnitude or norm) of the vector.
   * http://mathworld.wolfram.com/Norm.html
   * https://en.wikipedia.org/wiki/Euclidean_vector#Length
   * @return Length of the vector
   */
  public float length() {
    return (float) Math.sqrt(x * x + y * y);
  }

  /**
   * Normalize vector
   * http://mathworld.wolfram.com/NormalizedVector.html
   * @return A new normalized vector
   */
  public OGLVector2 normalize() {
    float length = length();
    return make(x / length, y / length);
  }

  /**
   * Negate vector
   * @return A new vector as a result of negating this vector
   */
  public OGLVector2 negate() {
    return multiply(-1);
  }

  /**
   * Add a vector
   * http://mathworld.wolfram.com/VectorAddition.html
   * @param v A vector to add
   * @return A new vector as a result of adding two vectors this and v (this + v)
   */
  public OGLVector2 add(OGLVector2 v) {
    return make(x + v.x, y + v.y);
  }

  /**
   * Subtract a vector
   * http://mathworld.wolfram.com/VectorDifference.html
   * @param v A vector to subtract
   * @return A new vector as a result of subtracting two vectors this and v (this - v)
   */
  public OGLVector2 subtract(OGLVector2 v) {
    return make(x - v.x, y - v.y);
  }

  /**
   * Multiply a scalar
   * http://mathworld.wolfram.com/ScalarMultiplication.html
   * @param s A scalar value to multiply
   * @return A new vector as a result of multiplying a scalar value to this (this x s)
   */
  public OGLVector2 multiply(float s) {
    return make(x * s, y * s);
  }

  /**
   * Divide by a scalar
   * http://mathworld.wolfram.com/ScalarMultiplication.html
   * @param s A scalar value to divide by
   * @return A new vector as a result of dividing this by a scalar value (this / s)
   */
  public OGLVector2 divide(float s) {
    return multiply(1 / s);
  }

  /**
   * Do a dot product
   * @param v A vector to do a dot product
   * @return Result of dot product of two vectors this and v (this dot a)
   */
  public float dot(OGLVector2 v) {
    return x * v.x + y * v.y;
  }
}
