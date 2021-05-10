import {API_BASE_URL, ACCESS_TOKEN} from '../constants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    });

    if (localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
        .then(response =>
            response.json().then(json => {
                if (!response.ok) {
                    return Promise.reject(json);
                }
                return json;
            })
        );
};

export function getAllParts() {
    return request({
        url: API_BASE_URL + "/inventory/get-all",
        method: 'GET'
    });
}

export function getSuitableParts(vehicleId) {
    return request({
        url: API_BASE_URL + "/inventory/get-all-suitable/" + vehicleId,
        method: 'GET'
    });
}

export function createUpdateInventoryItem(inventoryItemDTO) {
    return request({
        url: API_BASE_URL + "/inventory/create-update-part",
        method: 'POST',
        body: JSON.stringify(inventoryItemDTO)
    });
}

export function getAllClientVehicles(clientId) {
    return request({
        url: API_BASE_URL + "/vehicle/get-client-vehicles/" + clientId,
        method: 'GET'
    });
}

export function getAllClients(accountId) {
    return request({
        url: API_BASE_URL + "/user/get-all-clients/" + accountId,
        method: 'GET'
    });
}

export function getAllTechnicians(accountId) {
    return request({
        url: API_BASE_URL + "/user/get-all-technicians/" + accountId,
        method: 'GET'
    });
}

export function getAllJobs(accountId) {
    return request({
        url: API_BASE_URL + "/job/get-all/" + accountId,
        method: 'GET'
    });
}

export function getActiveJobs() {
    return request({
        url: API_BASE_URL + "/job/get-active",
        method: 'GET'
    });
}

export function createUpdateJob(jobDTO) {
    return request({
        url: API_BASE_URL + "/job/create-update",
        method: 'POST',
        body: JSON.stringify(jobDTO)
    });
}

export function createUpdateUser(userDTO) {
    return request({
        url: API_BASE_URL + "/user/create-update",
        method: 'POST',
        body: JSON.stringify(userDTO)
    });
}

export function createUpdateVehicle(vehicleDTO) {
    return request({
        url: API_BASE_URL + "/vehicle/create-update",
        method: 'POST',
        body: JSON.stringify(vehicleDTO)
    });
}

export function changeJobStatus(jobId, newStatus) {
    return request({
        url: API_BASE_URL + "/job/update-status/" + jobId + "/" + newStatus,
        method: 'GET'
    });
}

export function getSummary(accountId) {
    return request({
        url: API_BASE_URL + "/summary/get/" + accountId,
        method: 'GET'
    });
}
