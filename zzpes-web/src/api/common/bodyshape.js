import {fetchList} from '../commonUtils'

export function fetchBdShapeList() {
  return fetchList('/jx3BodyShapeInfo')
}
