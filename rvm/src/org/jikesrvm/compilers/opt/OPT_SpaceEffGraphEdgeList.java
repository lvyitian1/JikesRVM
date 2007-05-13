/*
 * This file is part of Jikes RVM (http://jikesrvm.sourceforge.net).
 * The Jikes RVM project is distributed under the Common Public License (CPL).
 * A copy of the license is included in the distribution, and is also
 * available at http://www.opensource.org/licenses/cpl1.0.php
 *
 * (C) Copyright IBM Corp. 2001
 */
package org.jikesrvm.compilers.opt;

/**
 */

import java.util.Enumeration;

//
// List of Graph Edges.
//
class OPT_SpaceEffGraphEdgeList
    implements Enumeration<OPT_SpaceEffGraphEdgeList> {
  OPT_SpaceEffGraphEdge _edge;
  OPT_SpaceEffGraphEdgeList _next;
  OPT_SpaceEffGraphEdgeList _prev;

  public boolean hasMoreElements() {
    return _next != null;
  }

  public OPT_SpaceEffGraphEdgeList nextElement() {
    OPT_SpaceEffGraphEdgeList tmp = _next;
    _next = _next._next;
    return  tmp;
  }

  public OPT_SpaceEffGraphEdge edge() {
    return  _edge;
  }

  public OPT_SpaceEffGraphEdgeList next() {
    return  _next;
  }

  public OPT_SpaceEffGraphEdgeList prev() {
    return  _prev;
  }

  public boolean inGraphEdgeList(OPT_SpaceEffGraphEdge edge) {
    OPT_SpaceEffGraphEdgeList n = this;
    while (n != null) {
      if (n._edge == edge)
        return  true;
      n = n._next;
    }
    return  false;
  }
}
