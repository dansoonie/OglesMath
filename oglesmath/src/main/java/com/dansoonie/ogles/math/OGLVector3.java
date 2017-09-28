package com.dansoonie.ogles.math;

import android.util.Log;

/**
 * Created by dansoonie on 17/9/28/.
 */

/**
 * Represents a 3 component vector. The component names are x, y, and z respectively.
 */
public class OGLVector3 {
  public static final String TAG = OGLVector3.class.getName();  // Tag for logging

  public static final int NUM_COMPONENTS = 3; // Number of components

  // Array index for each component
  public static final int X = 0;
  public static final int Y = 1;
  public static final int Z = 2;

  // The components for the vector
  public final float x;
  public final float y;
  public final float z;

  protected float[] mArray;

  protected OGLVector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Create a new vector
   * Each component is initialized to 0.
   * @return A new vector with each component initialized to 0.
   */
  public static OGLVector3 make() {
    return new OGLVector3(0, 0, 0);
  }

  /**
   * Create a new vector
   * Each component initialized with the given parameters.
   * @param x Value for x component
   * @param y Value for y component
   * @param z Value for z component
   * @return A new vector with each component initialized with the given parameters
   */
  public static OGLVector3 make(float x, float y, float z) {
    return new OGLVector3(x, y, z);
  }

  /**
   * Get an array containing values for all the components of the vector. The order of values for
   * each component in the array is x, y, and z.
   * WARNING: The values inside the array is mutable and can cause undesirable side effects. Use
   * debug mode to get warnings about it.
   * @return An array containing values for all the components of the vector
   */
  public float[] toArray() {
    if (mArray == null) {
      mArray = new float[NUM_COMPONENTS];
      mArray[X] = x;
      mArray[Y] = y;
      mArray[Z] = z;
    } else {
      if (OGLMath.isDebugMode()) {
        if (mArray[X] != x &&
            mArray[Y] != y &&
            mArray[Z] != z) {
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
    return (float) Math.sqrt(x * x + y * y + z * z);
  }

  /**
   * Normalize vector
   * http://mathworld.wolfram.com/NormalizedVector.html
   * @return A new normalized vector
   */
  public OGLVector3 normalize() {
    float length = length();
    return make(
        x / length,
        y / length,
        z / length);
  }

  /**
   * Negate vector
   * @return A new vector as a result of negating this vector
   */
  public OGLVector3 negate() {
    return multiply(-1);
  }

  /**
   * Add a vector
   * http://mathworld.wolfram.com/VectorAddition.html
   * @param v A vector to add
   * @return A new vector as a result of adding two vectors this and v (this + v)
   */
  public OGLVector3 add(OGLVector3 v) {
    return make(
        x + v.x,
        y + v.y,
        z + v.z);
  }

  /**
   * Subtract a vector
   * http://mathworld.wolfram.com/VectorDifference.html
   * @param v A vector to subtract
   * @return A new vector as a result of subtracting two vectors this and v (this - v)
   */
  public OGLVector3 subtract(OGLVector3 v) {
    return make(
        x - v.x,
        y - v.y,
        z - v.z);
  }

  /**
   * Multiply a scalar
   * http://mathworld.wolfram.com/ScalarMultiplication.html
   * @param s A scalar value to multiply
   * @return A new vector as a result of multiplying a scalar value to this (this x s)
   */
  public OGLVector3 multiply(float s) {
    return make(
        x * s,
        y * s,
        z * s);
  }

  /**
   * Divide by a scalar
   * http://mathworld.wolfram.com/ScalarMultiplication.html
   * @param s A scalar value to divide by
   * @return A new vector as a result of dividing this by a scalar value (this / s)
   */
  public OGLVector3 divide(float s) {
    return multiply(1 / s);
  }

  /**
   * Do a dot product
   * @param v A vector to do a dot product
   * @return Result of dot product of two vectors this and v (this dot a)
   */
  public float dot(OGLVector3 v) {
    return x * v.x + y * v.y + z * v.z;
  }

  /**
   * Do a cross product
   * @param v A vector to do a cross product
   * @return A new vector as a result of doing a cross product between this and v (this x v)
   */
  public OGLVector3 cross(OGLVector3 v) {
    return make(
        y * v.z - z * v.y,
        z * v.x - x * v.z,
        x * v.y - y * v.x);
  }
}
