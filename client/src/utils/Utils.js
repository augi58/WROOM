export function hasRole(user, role) {
    let hasRole = false;
    for (let i = 0; i < user.role.length; i++) {
        if (user.role[i].name == role) {
            hasRole = true;
            break;
        }
    }
    return hasRole;
}
