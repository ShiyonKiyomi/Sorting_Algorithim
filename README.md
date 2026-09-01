Original code
//selection

      for(int i = 0 ; i < array.length ; i ++){
            //holds the value of the index
            int min_idx = i;
      /**comparse the index to min_idx**/
      for (int j = i + 1 ; j < array.length ; j ++ ){
        if(array[j] < array[min_idx]){
          min_idx = j;
        }
      }

      //swaps the 
      int temp = array[i];
      array[i] = array[min_idx];
      array[min_idx] = temp;
    }

//insertion


      //insertion short
      for(int i = 1 ; i < numbersArray.length ; i ++){
            int key = numbersArray[i];
            int j = i - 1;
          
      while( j>=0 && numbersArray[j] > key){
            numbersArray[j + 1] = numbersArray[j];
                  j--;
            }
      numbersArray[j+1] = key;
      }
