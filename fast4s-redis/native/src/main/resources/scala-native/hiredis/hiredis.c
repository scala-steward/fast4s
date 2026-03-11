#include <string.h>
#include "hiredis/hiredis.h"

void __sn_wrap_hiredis_hiredisSetAllocators(hiredisAllocFuncs * ha, hiredisAllocFuncs *____return) {
  hiredisAllocFuncs ____ret = hiredisSetAllocators(ha);
  memcpy(____return, &____ret, sizeof(hiredisAllocFuncs));
}