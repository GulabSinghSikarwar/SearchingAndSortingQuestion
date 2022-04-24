 if (dx < n && dx >= 0 && dy < m && dy >= 0 && 
                image[dx][dy] == starting_color &&
                visited[dx][dy]==false) {
                    q.add(new Pair(dx, dy));

                }